import React, {Component} from 'react';
import PrimarySearchAppBar from "../components/PrimarySearchAppBar";

export default class Dashboard extends Component {
   constructor(props) {
     super(props);
   }

   render(){
      return (
          <PrimarySearchAppBar />
      );
   }
}
