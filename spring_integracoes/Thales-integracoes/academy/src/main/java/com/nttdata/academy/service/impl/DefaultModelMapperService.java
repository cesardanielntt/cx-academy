package com.nttdata.academy.service.impl;

import com.nttdata.academy.service.ModelMapperService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service("modelMapperService")
public class DefaultModelMapperService implements ModelMapperService {

    private static final Logger LOG = LogManager.getLogger(DefaultModelMapperService.class);


    @Override
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
}
