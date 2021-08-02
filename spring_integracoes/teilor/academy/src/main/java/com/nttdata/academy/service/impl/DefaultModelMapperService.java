package com.nttdata.academy.service.impl;

import com.nttdata.academy.service.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service("modelMapperService")
public class DefaultModelMapperService implements ModelMapperService {

    @Override
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
