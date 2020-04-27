import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthService } from '../service/hardcoded-auth.service';
import { BasicAuthenticationService } from '../service/basic-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private hardAuthService: HardcodedAuthService, private basicAuthenticationService: BasicAuthenticationService) { }

  ngOnInit() {
  }
  username = "aashray";
  password= "";
  invalidLogin = false;
  errorMessage = "Invalid Credentials";

  handleBasicAuthLogin() {
    // if (!(this.username==="aman" &&  this.password === '123')) {
    this.basicAuthenticationService.executeAuthenticationService(this.username, this.password)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['welcome', this.username])
            this.invalidLogin = false
          },
          error => {
            console.log(error)
            this.invalidLogin = true
          }
          
        )
      
    
      
  }

  handleJWTAuthLogin() {
    // if (!(this.username==="aman" &&  this.password === '123')) {
    this.basicAuthenticationService.executeJWTAuthenticationService(this.username, this.password)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['welcome', this.username])
            this.invalidLogin = false
          },
          error => {
            console.log(error)
            this.invalidLogin = true
          }
          
        )
      
    
      
  }
    
  

  // handleLogin() {
  //   // if (!(this.username==="aman" &&  this.password === '123')) {
  //   if(this.hardAuthService.authenticate(this.username, this.password)) {
  //     this.invalidLogin = false;
  //     this.router.navigate(['welcome', this.username]); 
  //   }
  //   else {
      
  //     this.invalidLogin = true;
  //   }
    
  //}

}
