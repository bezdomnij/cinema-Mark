import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ScreeningService} from "../../service/screening.service";
import {handleValidationErrors} from "../../utils/validation.handler";
import {Router} from "@angular/router";

@Component({
  selector: 'app-screening-form',
  templateUrl: './screening-form.component.html',
  styleUrl: './screening-form.component.css'
})
export class ScreeningFormComponent {

  form!: FormGroup;

  constructor(
    private screeningService: ScreeningService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.form = this.formBuilder.group({
      title: ['', [Validators.required]],
      screeningDate: ['', [Validators.required]],
      totalSeats: [0, [Validators.required, Validators.min(1)]],
      pictureUrl: ['']
    })
  }

  onSubmit() {
    this.screeningService.saveScreening(this.form.value).subscribe({
      next: () => {
        console.log((this.form.value));
        this.form.reset()
      },
      error: err => {
        console.error(err);
        handleValidationErrors(err, this.form)
      },
      complete: () => {
        console.log('Complete submit');
        this.router.navigate(['screenings']);
      }
    })
  }
}
