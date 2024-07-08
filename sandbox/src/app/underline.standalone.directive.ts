import {Directive, ElementRef, HostListener} from '@angular/core';

@Directive({
  selector: '[underline]',
  standalone: true,
})
export class UnderlineStandaloneDirective {

  constructor(private el: ElementRef) {
  }

  @HostListener('mouseenter')
  onMouseEnter() {
    this.el.nativeElement.style.textDecoration = 'underline';
  }

  @HostListener('mouseleave', ['$event.target'])
  onMouseLeave(elFromArgs: { style: { textDecoration: string; }; }) {
    elFromArgs.style.textDecoration = 'none';
  }
}
