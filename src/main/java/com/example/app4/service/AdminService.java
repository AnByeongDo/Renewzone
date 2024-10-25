package com.example.app4.service;

import com.example.app4.dto.AdminDTO;
import com.example.app4.dto.BoardDTO;
import com.example.app4.entity.AdminEntity;
import com.example.app4.entity.BoardEntity;
import com.example.app4.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public List<AdminDTO> findAll() {
        List<AdminEntity> adminEntityList = adminRepository.findAll();
        List<AdminDTO> adminDTOList = new ArrayList<>();

        for (AdminEntity adminEntity: adminEntityList){
            adminDTOList.add(AdminDTO.toAdminDTO(adminEntity));
        }
        return adminDTOList;
    }

    public void save(AdminDTO adminDTO) {
        AdminEntity adminEntity = AdminEntity.toAdminEntity(adminDTO);
        adminRepository.save(adminEntity);

    }

    public AdminDTO login(AdminDTO adminDTO) {
        //아이디로 DB 조회
        //조회한 아이디와 사용자 입력한 비밀번호가 일치하는 지
        Optional<AdminEntity> byAdmId = adminRepository.findByAdmId(adminDTO.getAdmId());
        if (byAdmId.isPresent()) {
            //정보가 있다
            AdminEntity adminEntity = byAdmId.get();
            if (adminEntity.getAdmPass().equals((adminDTO.getAdmPass()))) {
                AdminDTO dto = AdminDTO.toAdminDTO(adminEntity);
                return dto;

            } else {
                //비밀번호 불일치
                return null;
            }
        } else {
            //조회가 없다
            return null;
        }

    }
}




