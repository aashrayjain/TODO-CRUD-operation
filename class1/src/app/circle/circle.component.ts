import { Component, OnInit, Input } from '@angular/core';
import { RadioControlValueAccessor, NgModel } from '@angular/forms';
import { Element } from '@angular/compiler';
import { element } from 'protractor';
import { DeprecatedI18NPipesModule } from '@angular/common';

@Component({
  selector: 'app-circle',
  templateUrl: './circle.component.html',
  styleUrls: ['./circle.component.css']
})
export class CircleComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  radius: number;
  area:number;
  cir:number;
  
  calculate(){
  
  this.cir=2*3.14*this.radius;
  
  }

}
