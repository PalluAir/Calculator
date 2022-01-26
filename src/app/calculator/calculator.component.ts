import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, FormControl, FormControlName, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { CalculatorServiceService } from '../service/calculator-service.service';


@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {


  totalAmount: any;
  // from: any;
  // to: any;
  // amount: any;
  currencyForm: FormGroup;
  selected: any;
  fromImage: any;
  toImage: any;
  submitted: boolean = false;
  // countries = ['INR','USD','EUR','GBP','JPY']
  countries = [
    { id: 1, name: 'INR', src: '../../assets/flags/in.svg' },
    { id: 2, name: 'USD', src: '../../assets/flags/us.svg'},
    { id: 3, name: 'EUR', src: '../../assets/flags/eu.svg' },
    { id: 4, name: 'GBP', src: '../../assets/flags/gb.svg'},
    { id: 5, name: 'JPY', src: '../../assets/flags/jp.svg' },
  ];


  constructor(private formBuilder: FormBuilder,private router: Router, public calculatorService: CalculatorServiceService) {
    this.currencyForm = formBuilder.group({
      amount: ['', Validators.required],
      from: ['', Validators.required],
      to: ['', Validators.required],
    });


  };


  get currencyFormControl() {
    return this.currencyForm.controls;
  }

  handleSelectionChange(value: any, select: any) {
    this.countries.forEach(country => {
      if (country.name === value) {
        if (select === "from")
          this.fromImage = country.src
        else
          this.toImage = country.src
      }
    });

  }

  ngOnInit(): void {
    //Set default values for the dropdown
    this.currencyForm.controls['from'].setValue(this.countries[0].name, { onlySelf: true });
    this.currencyForm.controls['to'].setValue("USD", { onlySelf: true });
    this.fromImage=this.countries[0].src;
    this.toImage=this.countries[1].src;
  }

  calculate() {
    console.log("VALUE", this.currencyForm.value);
    console.log(this.currencyForm.valid)
    this.submitted = true;
    if(this.currencyForm.valid){
      this.calculatorService.getTotalAmount(this.currencyForm.value).subscribe(response =>{
          this.totalAmount=response.totalCalculatedAmount;
          console.log(response);
        });
    }else{
      //show error
      alert("Invalid Form");
      return;
    }

  }


  transaction() {
    this.router.navigateByUrl('/transaction');
  }
}