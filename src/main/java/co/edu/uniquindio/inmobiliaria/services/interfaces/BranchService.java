package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.BranchDTO;

import java.util.List;

public interface BranchService {
    List<BranchDTO> getAllBranches();
    BranchDTO getBranchById(Integer id);
    void createBranch(BranchDTO branch);
    void updateBranch(Integer id, BranchDTO branch);
    void deleteBranch(Integer id);
}
