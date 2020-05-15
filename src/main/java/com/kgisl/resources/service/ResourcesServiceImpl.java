  
  
package com.kgisl.resources.service;

import java.util.*;  

import javax.transaction.Transactional;

import com.kgisl.resources.entity.*;
import com.kgisl.resources.repository.ResourcesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    ResourcesRepository resourcesRepository;

          
    public Resources create(Resources resources){
    String resourcesName=resources.getResName();
    System.out.println(resourcesName);
    Boolean b=resourcesRepository.existsByresName(resourcesName);
    if(b==false){
    return resourcesRepository.save(resources);
    }
    else {
    return null;
    } 
   
    
    }
    public List<Resources> getResources(Resources resources){
    String resourcesName=resources.getResName();
    System.out.println(resourcesName);
    Boolean b=resourcesRepository.existsByresName(resourcesName);
    System.out.println(b);
    if(resourcesName == null){
    System.out.println("null resources");
      Level l=new Level(1,"Beginner");
      Level l2=new Level(2,"Intermediate");
      Level l3=new Level(3,"Professional");
     Resources r=new Resources(0,"https://userspringboot.herokuapp.com/images/js2.png","Java Script Basics 1","Java Script","Video","LMS.com",l);
      Resources r1=new Resources(0,"https://userspringboot.herokuapp.com/images/js1.png","Java Script Fundamentals 1","Java Script","Video","LMS.com",l);
      Resources r2=new Resources(0,"https://userspringboot.herokuapp.com/images/java1.png","AngularJS : Getting started 1","AngularJS","Video","LMS.com",l);
      Resources r3=new Resources(0,"https://userspringboot.herokuapp.com/images/angu1.png","Java Basics 1","Java","Video","LMS.com",l);
     Resources r4=new Resources(0,"https://userspringboot.herokuapp.com/images/angjs1.jpg	","Angular First Look ","Angular","Video","LMS.com",l);
     Resources r5=new Resources(0,"https://userspringboot.herokuapp.com/images/ts.png","AngularJS with TypeScript","AngularJS","Video","LMS.com",l2);
     Resources r6=new Resources(0,"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMPEA8PExIWFQ4PFhUPFxIVFRcYFRUVFxUWGRUXFRUYHiogGBooHRUXITEhJSktLi4uFx8zODMvOCgtLi4BCgoKDg0OGxAQGi0lHyYtLy0rKy0tLS0tLS0tLS0rLS0rLS0tLS0tLS0tLS0tKy0rLS0tLS0tLS0tLS0tLS0tLf/AABEIAKgBLAMBEQACEQEDEQH/xAAcAAEBAQADAQEBAAAAAAAAAAAAAQIDBAUGBwj/xABCEAACAQIEBAIGBwUFCQAAAAAAAQIDEQQSITEFQVFhBnEHEyIygZEUQlKxwdHwI3KCoeFig7Kz8RUkJTM0NWN0ov/EABoBAQADAQEBAAAAAAAAAAAAAAABAgMEBQb/xAAzEQEBAAIBAwIDBgUDBQAAAAAAAQIRAxIhMQRBIlFhE3GBkeHwFDKhscEF0fEjM1Jicv/aAAwDAQACEQMRAD8A+TAAAAACAQCAQCMDLAjAjAywIwMsCMDLAjAjAyBAIBAIBAIBAAAAAAAAAAAAA9wAAAAQCAAMsCARgRgZYEYEYGWBGBlgRgZAjAjAywIBGBAIBGAAAAAAAAAAAAAD3AAAABAIwIBAIwIwMsCMDLAjAjAywIwMsCMDIEAjAgEAgEAgAAAAAAAAAAAAAPcAAAIAAgEAjAywIwIwMsBfTbnuRruMtgSUm7dhJIMtkjLAjAywFiNjLJGWBAIwIwAEAAAAAAAAAAAAAB7gAABAIwIwIBAIwMsCMCMArWfX+Xci72MpXaXNi2SbHoY/DQjTptL2krTs+fU4PT82eXJlMr29lMbdvOklZWvfud0uW+67DROwUG/Lr/Ui5SIclHDOWu0ftcvnz+FzLPmmPb3+X7/zotdx1adKE6ajmnJWcn9V/wBnuc3Ry8ucz3qT2+f3q6t7vKaO/a7M42EsoySIBAIAAAAAAAAAAAAAAB7gAABAIBAIBGBkCMDLA5I4eTi5pezFpN+ZllzYY5zC3vUb9nE42NN78Jc9COXXm9jn5L1dvZWuw5XT6d+n6sYa1UOjVil1a+7tf4HXhlaszTpylskl1f5sZZY4+aOxhqkYSze+1u5e4r9uZhy45Z46/ln08/oi93LThKpPLF/tLc/qr8PJfeZZZYceHVl/L/f9/P8Awjw82rHK7PkduNmU3FmKcrNPoWym5odjilaM55otu6V79eZz+lwyww6cvw+5GM06R1LI0BAIAAAAAAAAAAAAAAB7gACAQCARgRgRgRgZYG6FCVR5Yq738lzZny8uPHj1ZVFunbpTyqUdk9Ne3Y5M8euzK91b3cUKaftLRr6t9L9jTLPKfDl+aWHWd320/Mn7PHRpEnLS2+l9v1rYWzHvserRwUVRc5azdsse6X5Hm5+ozvNMcPHvVLe7xK0m/e0j0XM9XCSfy+fm0jloOOR8p3Sj9lJ833MuSZdf013+aKxUTp1Wk7u+62ZbGzk4t2HmOTFVrzd0k+cejXKxlxcesJrvPmiR6nCfC1fGYeriqNJVIUpulKEbqrdRjK8YtLMrSWzv2Ndcmu1T3ebDh8ZSytTjJOzT3TW6aet+xhn6nkwntf3+CLlY6/EKFKFo05uUl7ztp8Ovma+n5ObPd5MdT2TLb5devOOSCUbSV7vr0NsMcplbb29kx1WbJAAAAAAAAAAAAAAAPcAAQCAQCARgRgZYEsRscuGquMlZtX0031MubCZYXaLHejWcrJu0le9tn3tscWXHMbuTc/rPx8qaMSpRiqlk1LRNEcVxyyuG72J8nPhcLCpCo9nD9amHNz58XJjPMqLbK41h3FZtH9lfafLyWhe8syvT4+f0/U2uKk42i9X73xd3/QrxSZbyn3EdGUU5Kds1nquv5HXLZhcZdfVZw4jDNN3jlzO6T08vMvx8uNna70mVJ4dxyys9dtPxZM5ZlubNrStKTUpWvz3+fL+RXPeOPwzaH6/6Ev8Ao8V/7L/yaR0cXirR8d6Za+XiUox0zUaTk1u9Zr7kvkRlxS59VNPhcJXUJxk1mS+q9hzcdzwuMuvqWOPETzSk7Wu726F+PHpxkI4S6QAAAAAAAAAAAAAAD3AIAAgEAywLCDk7JXbK5ZTGbok4tOz3ROOUym4MEjlr1c6h7KWVZdFvbm+5jx8fRbu27u+/t9PuRJpnDrVX2v8AkTy76bor3MNwWrjKqpYaDqNWzPaMU+c5PRfHe2lzi9L9pZ8UVx2+2j6Kp/R7PFf71ull/Yr+z9r+L/5Or+Hx8+62nydfglfASyVqbhqva3pzvmTcZ7PfbdaXR5nrMct6ynz1/Rnk8+piMin7PPS/L4FceLrs7/ea2uCwVWs4ySypWvOW11e+n1ncjn9Rw8EuNu/pP32LZHe4hwSbeeErvmrJP+H8n8zj9N/qPHJ0ZzU9vf8AP9FMc57uh6/WSqq01pZx1jbb5nZ9n2l4vH3+VtfJ59WcqtorXbKtlryS5s7MZjxfF+fzXnZ9d4Y9GmJxTVSvfD0OklerL92G0F3lr2e51Y4XKd1tP0jwL4ZlwyliKMqiqRqVnVhJJp5XTpxtKPJ3i9m/wNcMenaX5V6af+6f3FL/ABVC3uPi+HcPq4moqNCnKrWlqoQV3bq3tFd20u5I/S+G+hqpOhKVfEqniZK8YQjnhDtUk7OT/dtbrID4PxJ4XxXDp5cRStFu0asfapT/AHZ8n2kk9NgPGA7uB4XOqnPSFFb1Zu0F5fafZHLz+rw4r0ecv/Gd7+n4q3KR2VgsPU9ilXkqq0TqxUadT91rWH8Rj/Eep4/i5OOdP/rd2ff8/wAEbynmPPxeEnRlkqRcZdHz7p7Nd0dfFzcfLj1cd3P3+S0svhvEYTJCnPMnnV7c1+f9V1Iw5uvK468Eu66xskAAAAAAAA9xgQCMCMCAQDVKq4NSW6KcnHM8bjfCLNpVqZ25Pd63GGEwmp4JNMTg1ZtaPVdyZnLbJ7JZ/wBSRugrvy1/Xcy5L0xFf0T4Loxhw7A5YqOahRm7JK8pU4uUnbdtu7ZfD+WJfLVfSpSji5UPo8/o8JOk62ZZsyllclT2yaXvmvblyIy5JDb7LxHSjLCYpTipRVKpKzV9VBtPzui2ePVjYV+CwqxqVqEHG6vG/NPXVNM8K4ZcfBnnMvasfEtfWnzbEA8bxRLLSjJWTclG/a0nbutNj0/9KnVy2Xxrf9l+Py9r0NYWNTEYmtOMZypwh6uTSeS8p5sl9tt/6n03B0y3HXeN4+48a+MKfC4QvTlUr1lJ04J5YvJlu5zs8q9pbJvXY3zzmKzteEvEtLidB16cZRySdKcJrWM1GMmk1o1aSd+/LYtjlsfkPpoj/wAU/uKX+KoVt7j9E9D+GhDhOHnGMVOrKtKckkpTca9WMXJ7u0Ukr8kWgnF/SCqFerThhZ1KGGlKFarnjGScUm/U03/zLX1u49rnNy+t4eLknHle9VuUl09/jPFsJDCeuxUoLCVoJ2qq6nGSuo+rabm2vqpNnUs/mLBxTqU017LnFWfRyWjM+W2ceVnyv9kXw9nEReKx7oVJS9XGdWEUmlljCM3FRVrL3VyPN47PTeinLxydVmNv1ts3v391J8OG4tDhMFRo1HRr1vWwjUlOk42g3vFRs22udyM/W53lzwmeGHTbJMt9/rvc7X20XK7s3EnpQx1HO6lKh6p03JWcb1EnZNXi7aNeZM/73DydPTll1dWvft9O1+cPeV4J6zQAAAAAAAAAe4BAIBAIwMgRgRgHIjUCEbuxXK6iHpvhs6cF7LzPXyPN/jeLkz89op1S1+7eHMTChwzAzqzjCEMNQzSk0kv2Ud2z0sMp0S+2mj8RxVKnKVSpmvmqyml1Tk2nbfb4nmXnz+17Tt82e7t+64/GU6+BxFWlOM6cqNW0otNe4+mz7Hp2y42xo/BeHZIzpTlNXhJN6rbqzx/UfaZYZYY4+Yyy3rT7CMk0mmmnqmtU/JnzFlxur5YKQPG8SVVkjDSU3JPI97Wkr2Xmen/pmGXXc+8mvP4xfDy930OSVHEYqFSSjUqRpqMJOzlZyby333+8+j9PzYZZal8+Pr/w3lfa+NvB9PitOClUlTrUs2SolmSzWupwdsy9lbNPTc67jLdrO34U8N0uGUHQpOUs0vWznN6ym4xi3ZaJWilZdOe5OM0Pxn0u4ynV4nKVOcZqFKnSk4tNKac7xuuaur9CL3H6T6IMbTnwuhRjOLrUXVz001nhmr1JRco7pNNNMnHwOv4x8ATr+vq4Ou6dWu3OpRqa06kmrScZWcqbfPdPsc/J6Ti5OScmU7xW4y3b8a8RYfF06yp4xVVWpxUIqq20oJJJUpaxcNF7rtfvc6Fnn4WSjUpye0ZRk/JSTZTklywyk95f7Ivh9LhcDNY/6RbNh5yrVVVi04ZZQna8ls9UrM8Xk9Rx30X2O9ZyYzpva7lnszuU6Ne7y6GNoZYNqvSqKMYy+jyhGMmtM2tmpM7s+D1HVZOjKbuuuW2fT6yL2Xftfvd7iVSTp4ytUj6t4lUY06cn+0koSV5Nb7LdnL6fDGcnFx8d6ujquVnibl7fn7KY+ZJ7Pmz2moAAAAAAAAA9sCARgRgQCMCMDLAgCMrakWbHdhxSezeZdHr8jiy9Fx+cZq/RTpjtYzitSvGlGpUlKnRiqcI5mowjFWSUVonbS9rvmV6M52t/M7urKSe0vxElnmDucNxdejGt6mpKKqRcJpPSUWmmpRej0e+65WK3lmOU9jbyVTs+/mdPVudku7w/HzoN5Jez72V6xf5b7rocfqPS8fPPjnf5+KrljL5e3ieJ1ZwUoRUI6Xle7+HRHk8fo+Hjz1nd32nszmMnl4dXDVLqXObum3z8z1sOXj1cflGm4xGrVqXi5SbfJu7e35L5E3Dh4/ikkO0fdeGPHWJwkYrEJ1sKko5pO9WLWl1N+8r8pXfcnD1usujzf8J6nn+L/HtXGP1UZujhXpKMN5J75pbtW5aLsy/2nNnLbPun+9/2N2vgKsVdpbX0f62OrC9ptYoYmpRqQq0pyp1Y6qcJOMl8Vy6rZl8al+g8N9MOKp0HTq0adbEJWhWbyJ96lOKtJ8/Zcb9tyw+J45x7EY+r63EVXOSuox2hBN6qEFolt3dlduxFHFi8PCMIOMryluun5nPxcmeWdmU1J4+qstdWjiJQ2d4uzcHfJL96KeqNs+PHPz5+fvPuvsnT0f8Aa0Ie3Rw8adZ7zbc1B/8AijLSP8+hx/wWefw83Jcsfl43/wDVnn+ivTb5rzK1WU5OcpOUnvJu7fxO7DDHDHpxmov4YLAAAAAAAAAA9sCAQCARgZYEYEYCCu0m7Lr0K5XU3Bmas3zJl3BkDVKpZpvVc11KZ4bmoipVneTktE3e3QYY6xkpHZweOlBNL6ys79Oxz8/psc9W+yLjty4VRlP2r5Xtbe5ly3PHD4fKK4nBN2i0127q6WvTYv1WTeU/f6jv/SJQzpv2IpadWcX2WOfTZO9/srrbrzr+xJVZSzOKlTSs1e+rl0WjN8eOdUvHJ8qnXydfD4pwWdJ292/J21tfkacnDM7029/KbNuxVq1atKUlZUs3ura/RL4/zMcMOHi5Jjf5teUdpXj1JfA9HGLtU0RlRyY6WezslZZdNNvxM+GdO5tEdNo6VkTGhXISDJIAAAAAAAAAAAAB7YEAgGWBAIwMsCMCMDIC5AyyRCKLK1kud3ry5civxb+iHNTr2Si13zc/j2McuPd3PyRpz0IWlGcdY3MeTLeNxy8ort8TeS995PNby0X3NnN6b4/HtNf5quPd4k6jb8z1JjJGjNSUlo9t+3yEmN7wcuGxk6bTi7c1/oZ8vBhyTWURZK686jbbe7NZjJEuVUpqKnb2W7X6mdzwuXRvuPQwlalKlNVF7a921+n63OTl4+XHlxvH491LLvs8ie/zPQnhdgskYAAAAAAAAAAAAAAHtMCAQCARgZYEYGWBANU52enNZfmUzxlndFcclZtPdFpZZuJbxFHI1dp3Slo779TPj5Oudp+aJduFs10lkCEDs4HFOlOM90t11XRnPz8M5cLirZuOXjGO+kVM6VlorGfo/Tfw/H01GOOo6KTT1R1Wyzss5sfiXVak0lZJaGXBxTimoiTTiqYi8IQ5Qu1116vmXx4pMrl71Oma9VSd1FLZWROGFxmrdkiyxUnBU2/YTvYrOLHr655Nd3Cn3+ZppKMkclGm5NJbsrllMZuoXFUHCTi/eRXi5JnjMp4JduE1SAAAAAAAAAAAAB7QEAjAyBGBGBAJKLW+hEyl8DLAjAzcDWVZW76q1l166lbcuqTXZDiZdKMBEijtY1U1l9W3sr36nNw3lu/tPwVm/d0r+X68zoWbxFeVR5pO7slfstivHx4cc1j2RJImIxDqNN2uko6aaIcfHMJqEmnCy6RMUc2LrKbTUVGySsub6mXFhlhNW7RI65slpIjY1F215lbNoSpUbd3qyccZJqJYLAAAAAAAAAAAAAHsgQCARgRgZYETtqRZsWrUcm23qyMMJjNQcbLDLAjAywIwIwJcCNkaGWSIAzEaG69dzy3S9lZVZfeUw45hvXuiRxGiUAoHocKnTUn6xXjZ/P4fE4/VY8tx/wCn5Vy37OriWnNte7fTyvob8csx7+UxwGqQAAAAAAAAAAAAAHsgQCMDLAjAjAywIBlgRgZYEYEYGWBGBAIBAIBAIAAAVMjQXGhCQAAAAAAAAAAAAAB7DAgEAjAywIwIwMsCMDLAjAywIwIwMgRgRgQCAAIAAAAAAAAAAAAAAAAAAAAD2AIBGBlgRgZYEYEYGWBGBlgQDLAjAgEAgEAgEAAAAAAAAAAAAAAAAAAAAAA9dgRgRgRgZYEYGWBGBlgRgRgZYEYEYEAyBAIAAgAAAAAAAAAAAAAAAAAAAAAH/9k=","Angular Big Look","Angular","Video","LMS.com",l3);
     Resources r7=new Resources(0,"https://userspringboot.herokuapp.com/images/python1.jpg","Python Machine Learning","Python","Video","LMS.com",l);
     Resources r8=new Resources(0,"	https://userspringboot.herokuapp.com/images/anjdepth.jpg","Angular Js InDepth ","Angular Js","Video","LMS.com",l3);
     Resources r9=new Resources(0,"	https://userspringboot.herokuapp.com/images/ML-made-easy-Python.jpg","Python Data science","Python","Video","LMS.com",l3);
     Resources r10=new Resources(0,"	https://userspringboot.herokuapp.com/images/python1.jpg","Python Basics","Python","Video","LMS.com",l);
     Resources r11=new Resources(0,"","Java Script: ES6","JS ES6","Video","LMS.com",l3);
     Resources r12=new Resources(0,"https://userspringboot.herokuapp.com/images/core%20java.jpg","Java","Java","Video","LMS.com",l);
     Resources r13=new Resources(0,"https://userspringboot.herokuapp.com/images/j3.png","Java 8","Java","Video","LMS.com",l2);
      Resources r14=new Resources(0,"https://userspringboot.herokuapp.com/images/core%20java.jpg","Core Java","Java","Video","LMS.com",l3);
     Resources r15=new Resources(0,"https://userspringboot.herokuapp.com/images/nodejs.jpg","Introduction to Node JS","Node JS","Video","LMS.com",l);
     Resources r16=new Resources(0,"https://userspringboot.herokuapp.com/images/adnodejs.jpg","Advanced Node JS","Node JS","Video","LMS.com",l3);
      Resources r17=new Resources(0,"https://userspringboot.herokuapp.com/images/nodejs.png","Node JS Express","Node JS","Video","LMS.com",l2);
     Resources r18=new Resources(0,"https://userspringboot.herokuapp.com/images/serv.png","Spring Boot Microservices ","Spring Boot Microservices","Video","LMS.com",l2);
     Resources r19=new Resources(0,"","Spring Framework","Spring","Video","LMS.com",l2);
      Resources r20=new Resources(0,"https://userspringboot.herokuapp.com/images/sp2.jpg","Spring Fundamentals","Spring","Video","LMS.com",l);
     Resources r21=new Resources(0,"https://userspringboot.herokuapp.com/images/hb.jpg","Hibernate","Hibernate","Video","LMS.com",l2);
     Resources r22=new Resources(0,"https://userspringboot.herokuapp.com/images/jq1.png","Jquery","Jquery","Video","LMS.com",l);
    //  resourcesRepository.save(r);
    //  resourcesRepository.save(r2);
    //  resourcesRepository.save(r3);
    //  resourcesRepository.save(r4);
    //  resourcesRepository.save(r5);
    //  resourcesRepository.save(r6);
    //  resourcesRepository.save(r7);
    //  resourcesRepository.save(r8);
     List<Resources> res = Arrays.asList(r,r1,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22);
     List<Resources> list = resourcesRepository.saveAll(res);
    //  List<Resources> list=  get();
     return list;

    }
    else{

     if(b==false ){
         resourcesRepository.save(resources);
            }
     else{
     System.out.println("resource is Already there...");
     }
    }
    
     return null;
    }
    public List<Resources> get(){
     
     return resourcesRepository.findAll();
   }

   public Resources findById(Long id){
 return resourcesRepository.findById(id).orElse(null);
   }

    public Resources update(Long id,Resources resources){
  Resources r = resourcesRepository.getOne(id);
  r.setResName(resources.getResName());
  r.setResType(resources.getResType());
  r.setResTech(resources.getResTech());
  r.setResUrl(resources.getResUrl());
  return resourcesRepository.save(r);
}
   public void deleteById(Long id){
 resourcesRepository.deleteById(id);
   }

   
}
