import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CalculatorServiceService {

  constructor(private http:HttpClient) { }

  public  getTotalAmount(form:any) : Observable<any>{
    const url=`http://localhost:8082/calculator/calculate/from/${form.from}/to/${form.to}/amount/${form.amount}`;
    return this.http.get<any>(url);

  }
}
