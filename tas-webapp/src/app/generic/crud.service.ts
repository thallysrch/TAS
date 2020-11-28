import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Accept: 'application/json'
    })
};

export abstract class CrudService<T, ID> {
    constructor(protected url: string,
                protected http: HttpClient) { }

    protected getUrl(): string {
        return this.url;
    }

    findAll(): Observable<T[]> {
        const url = `${this.getUrl()}`;
        return this.http.get<T[]>(url);
    }

    getTotalRecords(): Observable<number> {
        const url = `${this.getUrl()}/count`;
        return this.http.get<number>(url);
    }

    findOne(id: ID): Observable<T> {
        const url = `${this.getUrl()}/${id}`;
        return this.http.get<T>(url);
    }

    save(t: T): Observable<void> {
        const url = `${this.getUrl()}`;
        return this.http.post<void>(url, JSON.stringify(t), httpOptions);
    }

    exists(id: ID): Observable<boolean> {
        const url = `${this.getUrl()}/exists/${id}`;
        return this.http.get<boolean>(url);
    }

    delete(id: ID): Observable<void> {
        const url = `${this.getUrl()}/${id}`;
        return this.http.delete<void>(url);
    }
}
