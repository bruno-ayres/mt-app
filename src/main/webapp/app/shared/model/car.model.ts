export interface ICar {
    id?: number;
    name?: string;
}

export class Car implements ICar {
    constructor(public id?: number, public name?: string) {}
}
