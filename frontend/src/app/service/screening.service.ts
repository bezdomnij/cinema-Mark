import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ScreeningCommandModel} from "../models/screening-command.model";

const BASE_URL = 'http://localhost:8080/api/screenings'

@Injectable({
  providedIn: 'root'
})
export class ScreeningService {

  constructor(
    private http: HttpClient,
  ) { }

  saveScreening(data: ScreeningCommandModel) {
    return this.http.post(BASE_URL, data)
  }
}
