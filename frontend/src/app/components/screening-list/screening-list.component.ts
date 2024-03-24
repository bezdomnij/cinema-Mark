import {Component, OnInit} from '@angular/core';
import {ScreeningService} from "../../service/screening.service";
import {ScreeningListItemModel} from "../../models/screening-list-item.model";

@Component({
  selector: 'app-screening-list',
  templateUrl: './screening-list.component.html',
  styleUrl: './screening-list.component.css'
})
export class ScreeningListComponent implements OnInit {

  screenings: ScreeningListItemModel[] = [];

  constructor(
    private screeningService: ScreeningService
  ) {
  }

  ngOnInit(): void {
    this.screeningService.fetchScreeningList().subscribe({
      next: data => this.screenings = data,
      error: err => console.error(err),
      complete: () => console.log('Screening list fetched')
    })
  }

}
