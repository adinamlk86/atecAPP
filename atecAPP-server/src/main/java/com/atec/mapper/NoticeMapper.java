package com.atec.mapper;


import com.atec.dto.NoticeDTO;
import com.atec.model.Notice;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface NoticeMapper {

    NoticeDTO toNoticeDTO(Notice notice);

    List<NoticeDTO> toNoticeDTOs(List<Notice> notices);

    Notice toNotice(NoticeDTO noticeDTO);

}
