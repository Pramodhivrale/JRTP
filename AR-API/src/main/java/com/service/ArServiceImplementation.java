package com.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bindings.CitizenBinding;
import com.constants.AppConstants;
import com.entity.ArEntity;
import com.entity.IesUserEntity;
import com.repo.AR_REPO;
import com.repo.IesRepo;

import om.utility.CaseNoGenrator;

@Service
public class ArServiceImplementation implements ArService {
	@Autowired
	private AR_REPO aRepo;

	@Autowired
	private IesRepo iesRepo;

	@Override
	public String registerApplication(CitizenBinding citizenBinding, String email) {

		ArEntity entity = new ArEntity();
		BeanUtils.copyProperties(citizenBinding, entity);
		try {
			String genCaseNo = CaseNoGenrator.genCaseNo(9);
			long caseNo = Long.parseLong(genCaseNo);
			entity.setCaseNo(caseNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		IesUserEntity byUserEmail = iesRepo.findByUserEmail(email);
		if (byUserEmail != null) {
			entity.setIesUser(byUserEmail);
		}

		aRepo.save(entity);

		return AppConstants.REG_COM;
	}

	public List<ArEntity> getAllApplicationOfCaseW() {

		return aRepo.findByUserId(3);

	}

}
