package com.example.javatutorials.annotation;

import com.example.javatutorials.data.entity.RegisterEntity;
import com.example.javatutorials.data.repository.IRegisterRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

//lombok
@RequiredArgsConstructor
public class UniqueEmailValidation implements ConstraintValidator<RegisterUniqueEmail, String> {

    //1.YOL
    //@Autowired
    //IUserRegisterRepository iUserRegisterRepository;

    //2.YOL ==> Constructor Injection
   /* public UniqueEmailValidation(IUserRegisterRepository iUserRegisterRepository) {
        this.iUserRegisterRepository = iUserRegisterRepository;
    }*/

    //3.YOL ==> Lombok
   private final IRegisterRepository iUserRegisterRepository;

    //Email addresinde database böyle bir email var mı yok mu
    public boolean isValid(String email, ConstraintValidatorContext context) {
        RegisterEntity userRegisterEntity = iUserRegisterRepository.findByEmail(email);
        //eğer bu email database varsa return false
        if (userRegisterEntity != null){
            return false;
        }
        return true;
    }
}
