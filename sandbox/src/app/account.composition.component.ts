import {Component, Input} from '@angular/core';
import {HighlightStandaloneDirective} from "./highlight.standalone.directive";
import {UnderlineStandaloneDirective} from "./underline.standalone.directive";

@Component({
  selector: 'account-composition',
  template: `Account composition: balance is: {{balance}}`,
  hostDirectives: [
    UnderlineStandaloneDirective,
    HighlightStandaloneDirective,
    // {
    //   directive: HighlightStandaloneDirective,
    //   inputs: ['color: color'],
    // }
  ],
  standalone: true,
})
export class AccountCompositionComponent {
  @Input()
  balance?: number;

  @Input()
  color?: string;
}
