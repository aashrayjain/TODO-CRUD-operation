import { Component, OnInit, ViewChild, AfterViewInit, OnDestroy } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { DataTableDirective } from 'angular-datatables';





export class Todo {
  constructor(public id: number, public description: string, public done: boolean, public targetDate: Date){}
}




@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit, OnDestroy {

  todos: Todo[];
  message: string;
  dtTrigger: Subject<any> = new Subject();
  @ViewChild(DataTableDirective, {static: false})
  datatableElement: DataTableDirective;
  dtOptions: DataTables.Settings = {};
  resp;

  // todos = [
  //   new Todo(1, 'Learn Java', true, new Date()),
  //   new Todo(2, 'Learn Angular', false, new Date()),
  //   new Todo(3, 'Learn Spring', false, new Date())
  //   // {id: 1, description: },
  //   // {id: 2, description: 'Learn Angular'},
  //   // {id: 3, description: 'Learn Spring'}
  // ]

  // todo = {
  //   id : 1,
  //   description: 'Learn To Dance'
  // }

  constructor(
    private todoService: TodoDataService,
    private router: Router
  ) { }


  t
 
  ngOnInit() {
    this.refreshTodos();
    
    this.dtOptions = {
      pagingType: 'full_numbers',
      lengthMenu: [ 5, 10, 15, 20 ],
      columnDefs: [


        { targets: 2, type: 'date' }
    
      ]
      
    };
   
  }
  


  refreshTodos() {
    
    this.todoService.retrieveAllTodos('aman').subscribe(
      response => {
        console.log(response);
        this.todos = response;
        this.resp = response;
        this.dtTrigger.next();        

      }
    )
  }

  deleteTodo(id) {
    console.log(`Delete ${id}`);
    this.todoService.deleteTodo('aman', id).subscribe(
      response => {
        console.log(response);
        this.message = `Delete ${id} successful` 
        this.dtTrigger.unsubscribe();
        this.refreshTodos();
      }
    )
  }

  updateTodo(id) {
    console.log(`Update ${id}`);
    this.router.navigate(['todos', id]);
  }

  addTodo() {
    this.router.navigate(['todos', -1]);
  }

  ngOnDestroy(): void {
    // Do not forget to unsubscribe the event
    this.dtTrigger.unsubscribe();
  }

  

}
