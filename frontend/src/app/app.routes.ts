import { Routes } from '@angular/router';
import { SeriesList } from './pages/series-list/series-list';
import { SeriesForm } from './pages/series-form/series-form';
import { SeriesView } from './pages/series-view/series-view';

export const routes: Routes = [
    { path: "", pathMatch: "full", redirectTo: "series" },
    { path: "series", component: SeriesList },
    { path: "nueva/serie", component: SeriesForm },
    { path: "serie/:id", component: SeriesView},
    { path: "actualizar/serie/:id", component: SeriesForm},
    {path: "**", redirectTo: "series"}
];
