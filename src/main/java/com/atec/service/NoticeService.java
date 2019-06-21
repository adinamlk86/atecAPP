package com.atec.service;


import com.atec.dto.NoticeDTO;
import com.atec.mapper.NoticeMapper;
import com.atec.model.Notice;
import com.atec.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeService {

    @Autowired
    private NoticeRepository repository;

    @Autowired
    private NoticeMapper mapper;

    @Transactional(readOnly = true)
    public List<NoticeDTO> getAll(){
        List<Notice> dbNotice = repository.findAll();

        return mapper.toNoticeDTOs(dbNotice);
    }


}
