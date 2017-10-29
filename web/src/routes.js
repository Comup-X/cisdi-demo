import Show from './Show.vue'
import Upload from './Upload.vue'
import Download from './Download.vue'

const routes = [
    {name: 'upload', path: '/upload', component: Upload},
    {name: 'download', path: '/download', component: Download},
    {name: 'show', path: '/*', component: Show},
];

export default routes;