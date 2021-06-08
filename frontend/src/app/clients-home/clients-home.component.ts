import { Component, OnInit } from '@angular/core';
import { faBook, faEdit } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-home',
  templateUrl: './clients-home.component.html',
  styleUrls: ['./clients-home.component.css']
})
export class ClientsHomeComponent implements OnInit {

  faBook = faBook;
  faEdit = faEdit;

  constructor() { }

  ngOnInit(): void {
  }

}
