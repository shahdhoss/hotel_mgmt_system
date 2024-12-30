package com.example.hotel.service;

import com.example.hotel.dto.GuestRegisterDto;
import com.example.hotel.dto.UserRegisterDto;
import com.example.hotel.entity.Guest;
import com.example.hotel.repository.GuestRepository;
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
    private final PasswordEncoder passwordEncoder = new PasswordEncoder() {
        @Override
        public String encode(CharSequence rawPassword) {
            return null;
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return false;
        }
    };
    public GuestService(GuestRepository guestRepository){
        this.guestRepository=guestRepository;
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
    public Guest getGuest(Long id){
        Optional<Guest> guestOptional= guestRepository.findById(id);
        if(guestOptional.isPresent()){
            Guest guest = guestOptional.get();
            return guest;
        }
        return null;
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
