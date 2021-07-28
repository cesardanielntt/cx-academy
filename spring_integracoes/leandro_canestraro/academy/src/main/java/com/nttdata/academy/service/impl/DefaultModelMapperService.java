package com.nttdata.academy.service.impl;

import com.nttdata.academy.service.ModelMapperService;
import org.modelmapper.ModelMapper;

public class DefaultModelMapperService implements ModelMapperService {
    @Override
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
