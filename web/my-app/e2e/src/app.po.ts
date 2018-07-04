import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/');
  }

  getPageLogo() {
    return element(by.id('hplogo'));
  }
}
