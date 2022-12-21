package com.student.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Address;
import com.student.entity.Course;
import com.student.entity.Student;
import com.student.exception.ResourseNotFoundException;
import com.student.payloads.AddressDto;
import com.student.repository.AddressRepo;
import com.student.repository.StudentRepo;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Address dtoToAddress(AddressDto dto) {
		
		Address user = this.modelMapper.map(dto, Address.class);
		 return user;
	}
	
	public AddressDto AddressToDto(Address user) {
		AddressDto dto = this.modelMapper.map(user, AddressDto.class);
		return dto;
	}

	@Override
	public List<AddressDto> viewAddress(Integer id) {
		List<Address> list = this.addressRepo.findAll();
		List<Address> list1 = new ArrayList<>();
		for(Address std:list) {
			
			
				if(std.getAddress_id()==id) {
					list1.add(std);
				
			}
			
		}
		return list1.stream().map(student->this.AddressToDto(student)).collect(Collectors.toList());
	}

	@Override
	public AddressDto addAddress(Integer student_id, AddressDto address) {
		Optional<Student> opt = studentRepo.findById(student_id);
		if(opt.isPresent()) {
			opt.get().getAddress().add(this.dtoToAddress(address));
			studentRepo.save(opt.get());
			return address;
		}
		return null;
	}
	@Override
	public AddressDto updateAddress(AddressDto addressDto, Integer student_id) {
        Address address =this.addressRepo.findById(student_id).orElseThrow(()-> new ResourseNotFoundException("Address", "Address_id", student_id));
		
		
		address.setArea(addressDto.getArea());
		address.setAddressType(addressDto.getAddressType());
		address.setDistrct(addressDto.getDistrct());
		address.setPincode(addressDto.getPincode());
		address.setState(addressDto.getState());
		Address updatedAddress = this.addressRepo.save(address);
		return this.AddressToDto(updatedAddress);
	}

	
}
