import { Directive, ElementRef, Input } from '@angular/core';

@Directive({
    selector: '[highlight-standalone]',
    standalone: true,
})
export class HighlightStandaloneDirective {

    @Input()
    color: string = 'red';

    constructor(private el: ElementRef) {}

    ngOnInit() {
        this.el.nativeElement.style.color = this.color;
    }
}
