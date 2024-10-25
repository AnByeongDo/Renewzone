package com.example.app4.dto;

import com.example.app4.entity.AdminEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AdminDTO {
    private Long id;
    private String admId;
    private String admPass;
    private String admName;

    public static AdminDTO toAdminDTO(AdminEntity adminEntity){
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(adminEntity.getId());
        adminDTO.setAdmId(adminEntity.getAdmId());
        adminDTO.setAdmPass(adminEntity.getAdmPass());
        adminDTO.setAdmName(adminEntity.getAdmName());
        return adminDTO;
    }

}
