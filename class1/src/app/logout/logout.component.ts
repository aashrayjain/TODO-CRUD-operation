import { Component, OnInit } from '@angular/core';
import { HardcodedAuthService } from '../service/hardcoded-auth.service';
import { BasicAuthenticationService } from '../service/basic-authentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private hardAuth : HardcodedAuthService, private basicAuthenticationService: BasicAuthenticationService) { }

  ngOnInit() {
    // this.hardAuth.logout();
    this.basicAuthenticationService.logout();
  }

}
