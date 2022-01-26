import { NgModule } from '@angular/core';
import { CalculatorComponent } from './calculator/calculator.component';
import { RouterModule, Routes } from '@angular/router';
import { TransactionComponent } from './transaction/transaction.component';

const routes: Routes = [
  { path: '',component: CalculatorComponent},
  { path: 'home',component: CalculatorComponent},
  { path: 'transaction',component: TransactionComponent},
  { path: '**', component: CalculatorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
