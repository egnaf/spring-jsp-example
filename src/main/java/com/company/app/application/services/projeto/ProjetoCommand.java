package com.company.app.application.services.projeto;

import com.company.app.application.dtos.ProjetoDTO;
import com.company.app.application.mappers.ProjetoMapper;
import com.company.app.core.bases.UseCaseFacade;
import com.company.app.core.usecases.projeto.UcProjetoCreate;
import com.company.app.core.usecases.projeto.UcProjetoDelete;
import com.company.app.core.usecases.projeto.UcProjetoEdit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjetoCommand implements IProjetoCommand {
    private final ProjetoMapper mapper = ProjetoMapper.INSTANCE;
    private final UseCaseFacade facade;

    public ProjetoDTO save(ProjetoDTO dto) {
        var result = mapper.toEntity(dto);
        return mapper.toDto(facade.execute(new UcProjetoCreate(result)));
    }

    public ProjetoDTO update(ProjetoDTO dto) {
        var result = mapper.toEntity(dto);
        return mapper.toDto(facade.execute(new UcProjetoEdit(result)));
    }

    public Void delete(Long id) {
        return facade.execute(new UcProjetoDelete(id));
    }
}
