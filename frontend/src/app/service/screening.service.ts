import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ScreeningCommandModel} from "../models/screening-command.model";
import {Observable} from "rxjs";
import {ScreeningListItemModel} from "../models/screening-list-item.model";

const BASE_URL = 'http://localhost:8080/api/screenings'

@Injectable({
  providedIn: 'root'
})
export class ScreeningService {

  constructor(
    private http: HttpClient,
  ) {
  }

  saveScreening(data: ScreeningCommandModel) {
    return this.http.post(BASE_URL, data);
  }

  fetchScreeningList(): Observable<ScreeningListItemModel[]> {
    return this.http.get<ScreeningListItemModel[]>(BASE_URL);
  }
}
