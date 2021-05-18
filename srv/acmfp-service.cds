using { com.sap.acm.fp as db } from '../db/schema';

@path : 'books'
service ACMFPService@(requires: 'authenticated-user') {

    entity Books as projection on db.Books;

}