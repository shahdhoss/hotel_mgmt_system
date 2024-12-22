package com.example.hotel.service;

import com.example.hotel.dto.GuestRegisterDto;
import com.example.hotel.dto.UserRegisterDto;
import com.example.hotel.repository.Guest;
import com.example.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestService implements UserService, UserDetailsService {

    private final GuestRepository guestRepository;
    private final PasswordEncoder passwordEncoder;

    public GuestService(GuestRepository guestRepository, PasswordEncoder passwordEncoder){
        this.guestRepository=guestRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserRegisterDto userDto) {
        if (userDto instanceof GuestRegisterDto guestDto) {
            Guest guest = new Guest();
            guest.setFirstName(guestDto.getFirstName());
            guest.setLastName(guestDto.getLastName());
            guest.setEmailAddress(guestDto.getEmailAddress());
            guest.setPassword(passwordEncoder.encode(guestDto.getPassword()));
            guestRepository.save(guest);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String emailAddress){
        Optional<Guest> optionalGuest = guestRepository.findByEmailAddress(emailAddress);
        if(optionalGuest.isPresent()){
            Guest guest = optionalGuest.get();
            return User.builder()
                    .username(guest.getEmailAddress())
                    .password(guest.getPassword())
                    .build();
        }else{
           throw new UsernameNotFoundException(emailAddress);
        }
    }
}
