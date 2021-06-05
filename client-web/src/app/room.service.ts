import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl = 'http://localhost:8087/api/v1/rooms';

  constructor(private http: HttpClient) {
  }

  createRoom(room: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, room);
  }

  updateRoom(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteRoom(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }

  getRoom(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getRoomsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getRoomByName(name: string): Observable<any> {
    if (name.length > 0) {
      return this.http.get(`${this.baseUrl}/name/${name}`);
    } else {
      return this.http.get(`${this.baseUrl}`);
    }
  }
}
