import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Seller } from '../interfaces/Seller';

const URL = 'http://localhost:8080/sellers';

@Injectable({
  providedIn: 'root',
})
export class SellersService {
  constructor(private http: HttpClient) {}
  getSellers(): Observable<Seller[]> {
    return this.http.get<Seller[]>(URL);
  }

  save(seller: Seller) {
    return this.http.post<Seller>(URL, seller);
  }

  update(seller: Seller) {
    return this.http.put<Seller>(URL + '/' + seller.id, seller);
  }

  delete(seller: Seller) {
    return this.http.delete<Seller>(URL + '/' + seller.id);
  }
}
