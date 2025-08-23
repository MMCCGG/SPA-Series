import {
  ApplicationConfig,
  provideBrowserGlobalErrorListeners,
  provideZoneChangeDetection,
} from "@angular/core";
import { provideRouter } from "@angular/router";
import { provideHttpClient } from "@angular/common/http";

import { routes } from "./app.routes";

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    // ERROR: NG0201: No provider found for `_HttpClient` - SOLUCIONADO
    // Se añadió provideHttpClient() para resolver el error de HttpClient no encontrado
    provideHttpClient(),
  ],
};
