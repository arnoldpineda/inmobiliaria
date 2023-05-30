package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.BranchDTO;
import co.edu.uniquindio.inmobiliaria.repositories.BranchRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.BranchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public BranchDTO getBranchById(Integer id) {
        return branchRepository.findById(id);
    }

    @Override
    public void createBranch(BranchDTO branch) {
        branchRepository.save(branch);
    }

    @Override
    public void updateBranch(Integer id, BranchDTO branch) {
        branchRepository.update(id, branch);
    }

    @Override
    public void deleteBranch(Integer id) {
        branchRepository.delete(id);
    }
}
