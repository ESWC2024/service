package com.example.eswc.service;

import com.example.eswc.model.Guardian;
import com.example.eswc.repository.GuardianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuardianService {

    private final GuardianRepository guardianRepository;

    @Autowired
    public GuardianService(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }

    // Guardian을 추가하고 저장된 Guardian 객체를 반환합니다.
    public Guardian addGuardian(Guardian guardian) {
        return guardianRepository.save(guardian);
    }

    // ID에 해당하는 Guardian을 조회하여 반환합니다.
    public Guardian getGuardianById(Long id) {
        return guardianRepository.findById(id).orElse(null);
    }

    // 모든 Guardian 객체 목록을 반환합니다.
    public List<Guardian> getAllGuardians() {
        return guardianRepository.findAll();
    }

    // ID에 해당하는 Guardian을 업데이트하고 성공 여부를 반환합니다.
    public boolean updateGuardian(Long id, Guardian updatedGuardian) {
        if (!guardianRepository.existsById(id)) {
            return false;
        }
        updatedGuardian.setId(id);  // 업데이트할 Guardian 객체에 ID 설정
        guardianRepository.save(updatedGuardian);
        return true;
    }

    // ID에 해당하는 Guardian을 삭제하고 성공 여부를 반환합니다.
    public boolean deleteGuardian(Long id) {
        if (!guardianRepository.existsById(id)) {
            return false;
        }
        guardianRepository.deleteById(id);
        return true;
    }
}
