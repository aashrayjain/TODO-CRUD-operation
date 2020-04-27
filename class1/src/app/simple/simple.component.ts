import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-simple',
  templateUrl: './simple.component.html',
  styleUrls: ['./simple.component.css']
})
export class SimpleComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  si: number;
  p: number;
  r: number;
  t: number;
  calculate() {
    this.si = ( this.p * this.r * this.t )/100;
  }

}
