package com.example.app4.entity;

import com.example.app4.dto.AdminDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Setter
@Getter
@Table(name="admin")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String admId;
    @Column()
    private String admPass;
    @Column()
    private String admName;

    public static AdminEntity toAdminEntity(AdminDTO adminDTO){
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setAdmId(adminDTO.getAdmId());
        adminEntity.setAdmPass(adminDTO.getAdmPass());
        adminEntity.setAdmName(adminDTO.getAdmName());
        return adminEntity;
    }
}
