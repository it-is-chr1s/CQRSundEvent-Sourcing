import ReactDOM from 'react-dom/client';
import InterfaceReservationSystem from './InterfaceReservationSystem';
import './index.css';

const rootNode = document.getElementById('root') as HTMLElement;
const root = ReactDOM.createRoot(rootNode);

root.render(<InterfaceReservationSystem />);
