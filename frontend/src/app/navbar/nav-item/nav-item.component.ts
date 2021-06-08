import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-item',
  templateUrl: './nav-item.component.html',
  styleUrls: ['./nav-item.component.css']
})
export class NavItemComponent implements OnInit {

  @Input() url: string = '#';
  @Input() label: string = '';

  constructor() { }

  ngOnInit(): void {
  }

}
