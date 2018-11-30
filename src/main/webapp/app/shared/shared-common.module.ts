import { NgModule } from '@angular/core';

import { MtSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [MtSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [MtSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class MtSharedCommonModule {}
