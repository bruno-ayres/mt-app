import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { MtCarModule } from './car/car.module';
import { MtCompanyModule } from './company/company.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        MtCarModule,
        MtCompanyModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MtEntityModule {}
