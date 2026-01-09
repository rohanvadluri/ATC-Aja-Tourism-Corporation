package com.aja.serviceImpl;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.aja.Dto.PackageDeleteResponseDto;
import com.aja.Dto.PackagesRequestDto;
import com.aja.Dto.PackagesResponseDto;
import com.aja.entity.Packages;
import com.aja.entity.States;
import com.aja.repository.PackagesRepo;
import com.aja.repository.StatesRepo;
import com.aja.service.PackageService;
 
@Service
public class PackageServiceImpl implements PackageService {
 
	@Autowired
	private PackagesRepo pRepo;
	@Autowired
	private StatesRepo sRepo;
 
	@Override
	public PackagesResponseDto addPackage(PackagesRequestDto p) {
 
	    Packages pack = new Packages();
	    BeanUtils.copyProperties(p, pack);
	    if (p.getStateId() != null) {
	        States state = sRepo.findById(p.getStateId())
	            .orElseThrow(() -> new RuntimeException("State not found"));
	        pack.setState(state);
	    }
 
	    Packages entity = pRepo.save(pack);
 
	    PackagesResponseDto pRes = new PackagesResponseDto();
	    BeanUtils.copyProperties(entity, pRes);
 
	    return pRes;
	}
 
	@Override
	public List<PackagesResponseDto> viewPackages() {
 
		List<Packages> viewAllPackages = pRepo.findByIsFlagTrue();
 
		List<PackagesResponseDto> resList = new ArrayList<>();
 
		for (Packages pack : viewAllPackages) {
 
			PackagesResponseDto dtoRes = new PackagesResponseDto();
 
			BeanUtils.copyProperties(pack, dtoRes);
 
			resList.add(dtoRes);
		}
 
		return resList;
	}
 
	@Override
	public PackagesResponseDto updatePackage(Long packageId, PackagesRequestDto p) {
 
		Optional<Packages> updateById = pRepo.findById(packageId);
 
		if (updateById.isEmpty()) {
			return null;
		}
 
		Packages pack = updateById.get();
 
		BeanUtils.copyProperties(p, pack, "packageId");
		// update only required or id--ignore fields
 
		Packages updated = pRepo.save(pack);
 
		PackagesResponseDto pres = new PackagesResponseDto();
 
		BeanUtils.copyProperties(updated, pres);
 
		return pres;
	}
 
	@Override
	public PackagesResponseDto getPackage(Long packageId) {
 
		Optional<Packages> viewById = pRepo.findById(packageId);
 
		Packages pack = null;
 
		if (viewById.isEmpty()) {
			return null;
		}
 
		pack = viewById.get();
 
		PackagesResponseDto pres = new PackagesResponseDto();
 
		BeanUtils.copyProperties(pack, pres);
 
		return pres;
	}
 
	@Override
	public PackageDeleteResponseDto deletePackage(Long id) {
 
		Optional<Packages> byId = pRepo.findById(id);
 
		PackageDeleteResponseDto pdelRes = new PackageDeleteResponseDto();
 
		if (byId.isPresent()) {
 
			Packages p = byId.get();
			// soft delete by flag
			p.setFlag(false);
			pRepo.save(p);
 
			pdelRes.setDeleted(true);
			pdelRes.setMessage("Package Deleted Successfully");
 
		} else {
			pdelRes.setDeleted(false);
			pdelRes.setMessage("Package Not Deleted Successfully");
		}
 
		return pdelRes;
	}
 
}