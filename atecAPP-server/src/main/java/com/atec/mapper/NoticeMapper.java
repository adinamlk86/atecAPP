package com.atec.mapper;


import com.atec.dto.NoticeDTO;
import com.atec.model.Notice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, EquipmentMapper.class})
public interface NoticeMapper {

    @Mapping(source = "client.id", target ="clientId")
    @Mapping(source = "equipment.id", target ="equipmentId")
    NoticeDTO toNoticeDTO(Notice notice);

    List<NoticeDTO> toNoticeDTOs(List<Notice> notices);

    @Mapping(source = "clientId", target ="client")
    @Mapping(source = "equipmentId", target ="equipment")
    Notice toNotice(NoticeDTO noticeDTO);

}
