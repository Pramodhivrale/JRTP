package com.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.StudentEnqEntity;
import com.entity.UserDtlsEntity;
import com.repo.CourseListRepo;
import com.repo.EnqstatusRepo;
import com.repo.StudentEnqRepo;
import com.repo.UserDetailsRepo;
import com.request.EnquiryForm;
import com.request.UpdateForm;
import com.response.DashBoardResponse;
import com.response.EnqSearchCreteria;

import jakarta.servlet.http.HttpSession;

@Service
public class EnquieryserviceImpl implements EnquieryService {
	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@Autowired
	private CourseListRepo courseListRepo;

	@Autowired
	private EnqstatusRepo enqstatusRepo;

	@Autowired
	private StudentEnqRepo studentEnqRepo;

	@Autowired
	private HttpSession httpSession;

	@Override
	public List<String> getCourseName() {
		List<String> getcourseList = courseListRepo.GetcourseList();

		return getcourseList;
	}

	@Override
	public List<String> getEnqStatus() {

		List<String> enqStatus = enqstatusRepo.getEnqStatus();
		return enqStatus;
	}

	@Override
	public DashBoardResponse getDashBoardResponse(Integer id) {

		DashBoardResponse sResponse = new DashBoardResponse();

		Optional<UserDtlsEntity> optional = userDetailsRepo.findById(id);

		if (optional.isPresent()) {
			UserDtlsEntity userDtlsEntity = optional.get();

			List<StudentEnqEntity> enquiries = userDtlsEntity.getEnquiries();

			int totalEnqcnt = enquiries.size();

			List<StudentEnqEntity> collect = enquiries.stream().filter(e -> e.getEnqStatus().equals("ENROLLED"))
					.collect(Collectors.toList());

			int enrollCnt = collect.size();

			List<StudentEnqEntity> collect2 = enquiries.stream().filter(e -> e.getEnqStatus().equals("LOAT"))
					.collect(Collectors.toList());

			int lostcnt = collect2.size();

			sResponse.setTotalEnqcnt(totalEnqcnt);
			sResponse.setLostcnt(lostcnt);
			sResponse.setEnrollCnt(enrollCnt);

		}
		return sResponse;
	}

	@Override
	public String upseartEnquiery(EnquiryForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentEnqEntity> getEnquries(Integer id) {

		Optional<UserDtlsEntity> byId = userDetailsRepo.findById(id);

		UserDtlsEntity userDtlsEntity = byId.get();
		List<StudentEnqEntity> enquiries = userDtlsEntity.getEnquiries();
		return enquiries;

	}

	@Override
	public EnquiryForm getEnq(Integer enqId) {

		return null;
	}

	public String addEnq(EnquiryForm enquiryForm) {
		StudentEnqEntity studentEnqEntity = new StudentEnqEntity();
		BeanUtils.copyProperties(enquiryForm, studentEnqEntity);

		Integer userid = (Integer) httpSession.getAttribute("UserID");

		UserDtlsEntity userDtlsEntity = userDetailsRepo.findById(userid).get();

		studentEnqEntity.setUser(userDtlsEntity);
		studentEnqRepo.save(studentEnqEntity);

		return " Enquiry added successfully!";

	}

	@Override
	public Optional<StudentEnqEntity> editEnq(Integer id) {
		Optional<StudentEnqEntity> byId = studentEnqRepo.findById(id);
		if (byId == null) {
			System.out.println("Enq not found");

		} else {
			return byId;
		}

		return byId;
	}

	@Override
	public String updateStudentData(Integer enqId, UpdateForm form) {
		Integer userId = (Integer) httpSession.getAttribute("UserID");

		Optional<UserDtlsEntity> userData = userDetailsRepo.findById(userId);

		if (!userData.isPresent()) {
			return "User not found";
		}

		Optional<StudentEnqEntity> byId = studentEnqRepo.findById(enqId);
		if (!byId.isPresent() || !byId.get().getUser().getUserId().equals(userId)) {
			return "Enquiry not found for this user";
		}

		StudentEnqEntity studentEnqEntity2 = byId.get();

		studentEnqEntity2.setStudentName(form.getStudentName());
		studentEnqEntity2.setPhonNo(form.getContactNo());
		studentEnqEntity2.setClassMode(form.getClassMode());
		studentEnqEntity2.setCourseName(form.getCourseName());
		studentEnqEntity2.setEnqStatus(form.getEnqStatus());

		studentEnqRepo.save(studentEnqEntity2);

		return "Data updated";
	}

	@Override
	public List<StudentEnqEntity> filterEnq(Integer id, EnqSearchCreteria creteria) 
	{
		System.out.println(creteria);
		Optional<UserDtlsEntity> byId = userDetailsRepo.findById(id);

		UserDtlsEntity userDtlsEntity = byId.get();
		List<StudentEnqEntity> enquiries = userDtlsEntity.getEnquiries();
		
		if (null != creteria.getCourseName() && !"".equals(creteria.getCourseName())) {

			enquiries = enquiries.stream().filter(e -> e.getCourseName().equals(creteria.getCourseName()))
					.collect(Collectors.toList());
			return enquiries;
		}

		if (null != creteria.getClassMode() && !"".equals(creteria.getClassMode())) {
			enquiries = enquiries.stream().filter(e -> e.getClassMode().equals(creteria.getClassMode()))
					.collect(Collectors.toList());
			return enquiries;

		}

		if (null != creteria.getEnqStatus() && !"".equals(creteria.getEnqStatus())) {
			enquiries = enquiries.stream().filter(e -> e.getEnqStatus().equals(creteria.getEnqStatus()))
					.collect(Collectors.toList());
			return enquiries;

		}
		System.out.println(enquiries.size());
		return enquiries;
	}

}
