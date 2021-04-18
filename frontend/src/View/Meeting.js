import React, {Component} from 'react';
import PrimarySearchAppBar from "../components/PrimarySearchAppBar";

export default class Messages extends Component {
   constructor(props) {
     super(props);
   }

   render(){
      return (
          <PrimarySearchAppBar />
      );
   }
}
