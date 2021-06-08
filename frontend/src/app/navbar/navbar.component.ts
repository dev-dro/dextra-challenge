import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { faUser } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  readonly clientProfile = 'CLIENT';
  readonly employeeProfile = 'EMPLOYEE';

  readonly profiles: {name: string, type: string}[] = [
    { name: 'Cliente', type: this.clientProfile },
    { name: 'Funcionário', type: this.employeeProfile }
  ]

  faUser = faUser;
  profileControl: FormControl = new FormControl(this.profiles[0].type);



  constructor() { }

  ngOnInit(): void {
  }

}
